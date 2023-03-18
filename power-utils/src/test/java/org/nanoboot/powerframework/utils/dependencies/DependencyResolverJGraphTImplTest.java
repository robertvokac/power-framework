
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

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */

public class DependencyResolverJGraphTImplTest {

    public DependencyResolverJGraphTImplTest() {
    }

    /**
     * Test of resolve method, of class DependencyResolverJGraphTImpl.
     */
    @Test
    public void testResolve() {
        System.out.println("resolve");
        //prepare
        List<DependencyNode> dependencyNodes = new ArrayList<>();

        dependencyNodes.add(new DependencyNode("development", Arrays.asList("task")));
        dependencyNodes.add(new DependencyNode("task"));
        dependencyNodes.add(new DependencyNode("person", Arrays.asList("task")));
        dependencyNodes.add(new DependencyNode("encyclopedia"));
        dependencyNodes.add(new DependencyNode("system"));
        dependencyNodes.add(new DependencyNode("favorite", Arrays.asList()));
        dependencyNodes.add(new DependencyNode("action-log", Arrays.asList()));
        dependencyNodes.add(new DependencyNode("pinning", Arrays.asList()));
        dependencyNodes.add(new DependencyNode("reminder", Arrays.asList()));
        dependencyNodes.add(new DependencyNode("whining", Arrays.asList()));
        for (DependencyNode dn : dependencyNodes) {
            if (!dn.getName().equals("system")) {
                dn.getDependencies().add("system");
            }
            if (dn.getName().equals("action-log") || dn.getName().equals("favorite") || dn.getName().equals("pinning") || dn.getName().equals("reminder") || dn.getName().equals("whining") || dn.getName().equals("system")) {
                //nothing to do
            } else {
                dn.getDependencies().addAll(Arrays.asList("action-log", "favorite", "pinning", "reminder", "whining"));
            }
        }

        DependencyResolverJGraphTImpl instance = new DependencyResolverJGraphTImpl();
        List<String> expResult = new ArrayList<>();
        expResult.addAll(Arrays.asList("system", "favorite", "action-log", "pinning", "reminder", "whining", "task", "encyclopedia", "development", "person"));
        //execute
        List<String> result = instance.resolve(dependencyNodes);
        for (String s : result) {
        }
        //assert
        assertEquals(expResult, result);
    }

}
