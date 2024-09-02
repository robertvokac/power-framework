
///////////////////////////////////////////////////////////////////////////////////////////////
// power-framework: Java library with many purposes of usage.
// Copyright (C) 2016-2024 the original author or authors.
//
// This program is free software: you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation, either version 3
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program. If not, see 
// <https://www.gnu.org/licenses/> or write to the Free Software
// Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
///////////////////////////////////////////////////////////////////////////////////////////////

package org.nanoboot.powerframework.utils.dependencies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;
import org.jgrapht.traverse.TopologicalOrderIterator;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class DependencyResolverJGraphTImpl implements DependencyResolver{
     public List<String> resolve(List<DependencyNode> dependencyNodesIn) {
        // DirectAcyclicGraph to prevent circular dependency
        Graph<DependencyNode, DefaultEdge> directedGraph = new DirectedAcyclicGraph<>(DefaultEdge.class);
        List<DependencyNode> dependencyNodes = dependencyNodesIn;
        Map<String, DependencyNode> taskNameToTaskMap = dependencyNodes.stream()
                .collect(Collectors.toMap(task -> task.getName(), task -> task));
        for (DependencyNode task : dependencyNodes) {
            directedGraph.addVertex(task);
            for (String predecessor : task.getDependencies()) {
                DependencyNode predecessorTask = taskNameToTaskMap.get(predecessor);
                directedGraph.addVertex(predecessorTask);
                directedGraph.addEdge(predecessorTask, task);
            }
        }
        TopologicalOrderIterator<DependencyNode, DefaultEdge> moreDependencyFirstIterator = new TopologicalOrderIterator<>(
                directedGraph);
        List<String> result = new ArrayList<>();
        moreDependencyFirstIterator.forEachRemaining(dependencyNode -> result.add(dependencyNode.getName()));
        return result;
    }
    
}
