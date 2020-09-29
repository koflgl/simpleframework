package com.lgl.simpleframework.core.util;

import java.io.UnsupportedEncodingException;
import java.util.Set;

import com.lgl.simpleframework.framework.core.util.ClassUtil;
import org.junit.Test;
/**
 * <p>
 * description
 * </p>
 *
 * @author lgl
 * @since 1.0
 */
public class ClassUtilTest {
    @Test
   public void extractPackageClassTest() throws UnsupportedEncodingException {
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("com.lgl.simpleframework");
        System.out.println(classSet);
    }
}
