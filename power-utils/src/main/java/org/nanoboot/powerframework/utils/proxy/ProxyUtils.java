
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

package org.nanoboot.powerframework.utils.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ProxyUtils {

    private static class InvocationHandlerImpl<T> implements InvocationHandler {

        private final T original;
        private final MethodInvoker methodInvoker;

        public InvocationHandlerImpl(T original, MethodInvoker methodInvoker) {
            this.original = original;
            this.methodInvoker = methodInvoker;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
            return this.methodInvoker.invoke(original, proxy, method, args);
        }
    }

    

    public static void main(String[] args) {
        //        class ListHandler implements InvocationHandler {
        //
        //            private final List originalList;
        //
        //            public ListHandler(List originalList) {
        //                this.originalList = originalList;
        //            }
        //
        //            @Override
        //            public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        //                StringBuilder argsAsOneString = new StringBuilder();
        //                if (args != null) {
        //                    for (Object arg : args) {
        //                        argsAsOneString.append(arg).append(", ");
        //                    }
        //                }
        //                String argsAsOneStringStr = argsAsOneString.toString();
        //                if (!argsAsOneStringStr.isEmpty()) {
        //                    argsAsOneStringStr = argsAsOneStringStr.substring(0, argsAsOneStringStr.length() - 2);
        //                }
        //                System.out.println("Calling List method: " + method.getName() + "(" + argsAsOneStringStr + ")");
        //                Object o = method.invoke(originalList, args); // zavolá původní metodu
        //                if (method.getName().equals("size")) {
        //                    return ((Integer) o) * 2;
        //                }
        //                if (method.getName().equals("add")) {
        //                    //again- for second time
        //                    return method.invoke(originalList, args); // zavolá původní metodu
        //                }
        //                return o;
        //            }
        //        }

        List<String> list = new ArrayList<>();

        //        List<String> proxyList = (List) Proxy.newProxyInstance(List.class.getClassLoader(),
        //                new Class[] {List.class}, new ListHandler(list));

        MethodInvoker methodInvoker = new MethodInvoker() {
            @Override
            public Object invoke(Object original, Object proxy, Method method, Object[] args) throws Exception {
                StringBuilder argsAsOneString = new StringBuilder();
                if (args != null) {
                    for (Object arg : args) {
                        argsAsOneString.append(arg).append(", ");
                    }
                }
                String argsAsOneStringStr = argsAsOneString.toString();
                if (!argsAsOneStringStr.isEmpty()) {
                    argsAsOneStringStr = argsAsOneStringStr.substring(0, argsAsOneStringStr.length() - 2);
                }
                System.out.println("Calling List method: " + method.getName() + "(" + argsAsOneStringStr + ")");
                Object o = method.invoke(original, args); // zavolá původní metodu
                if (method.getName().equals("size")) {
                    return ((Integer) o) * 2;
                }
                if (method.getName().equals("add")) {
                    //again- for second time
                    return method.invoke(original, args); // zavolá původní metodu
                }
                return o;
            }
        };
        List<String> proxyList2 = createProxy(list, List.class, methodInvoker);
        proxyList2.add("ahoj");
        proxyList2.add("dobry den");
        proxyList2.add("na shledanou");
        proxyList2.add("zdar");
        System.out.println("proxyList.size()=" + proxyList2.size());
        proxyList2.get(0);
        for (String s : proxyList2) {
            System.out.println("s = " + s);
        }
    }

    public static <T> T createProxy(T original, Class<T> interfaceClazz, MethodInvoker methodInvoker) {
        return (T) Proxy.newProxyInstance(interfaceClazz.getClassLoader(),
                new Class[] {interfaceClazz}, new InvocationHandlerImpl(original, methodInvoker));
    }
}

 
