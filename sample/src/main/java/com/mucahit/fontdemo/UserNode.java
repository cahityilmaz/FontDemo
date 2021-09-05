package com.mucahit.fontdemo;

import java.beans.IntrospectionException;
import org.openide.nodes.BeanNode;

/**
 *
 * @author mucahit.yilmaz
 */
public class UserNode extends BeanNode {
    

    public UserNode(User user) throws IntrospectionException {
        super(user);
        setDisplayName(user.getName());
    }
    
}
