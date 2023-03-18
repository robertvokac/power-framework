
///////////////////////////////////////////////////////////////////////////////////////////////
// power-framework: Java library with many purposes of usage.
// Copyright (C) 2016-2022 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation;
// version 2.1 of the License only.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
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
