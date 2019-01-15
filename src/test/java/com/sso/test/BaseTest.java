package com.sso.test;

import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.test4j.junit.Test4J;

/**
 * Spring单元测试基类
 */
@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
@RunWith(JUnit4ClassRunner.class)
public class BaseTest extends Test4J {
}
