package com.github.flmn.util;

import org.junit.jupiter.api.Test;

class CaseUtilsTest {

    @Test
    void toPascalCase() {
    }

    @Test
    void toCamelCase() {
    }

    @Test
    void toSnakeCase() {
        System.out.println(CaseUtils.toSnakeCase("hello  world"));
        System.out.println(CaseUtils.toSnakeCase("Hello World"));
        System.out.println(CaseUtils.toSnakeCase("HelloWorld"));
        System.out.println(CaseUtils.toSnakeCase("helloWorld"));
        System.out.println(CaseUtils.toSnakeCase("hello-world"));
    }

    @Test
    void toKebabCase() {
    }
}