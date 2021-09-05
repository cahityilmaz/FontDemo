package com.mucahit.fontdemo;

import java.beans.IntrospectionException;
import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;

/**
 *
 * @author mucahit.yilmaz
 */
public class UserNodeFactory extends ChildFactory<User> {

    @Override
    protected boolean createKeys(List<User> list) {

        for (int i = 0; i < 10; i++) {
            User node = new User("Mücahit", "Yılmaz");
            list.add(node);
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(User key) {
        try {
            return new UserNode(key);
        } catch (IntrospectionException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }

}
