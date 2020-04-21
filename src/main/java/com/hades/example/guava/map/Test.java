package com.hades.example.guava.map;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        Optional<List<byte[]>> listOptional1 = test.get(HOST_1);
        Optional<List<byte[]>> listOptional2 = test.get(HOST_2);
        Optional<List<byte[]>> listOptional3 = test.get(HOST_3);
        System.out.println(listOptional1);
        System.out.println(listOptional2);
        System.out.println(listOptional3);
    }

    public static final String HOST_1 = "abc";
    public static final String HOST_2 = "def";
    public static final String HOST_3 = "xyz";

    byte[] CERTIFICATE_FINGER_PRINT_1 = {12, 50};
    byte[] CERTIFICATE_FINGER_PRINT_2 = {18, 30};
    Optional<List<byte[]>> emptyList_4_certificate_finger_print = Optional.<List<byte[]>>of(new ArrayList<byte[]>());

    ImmutableMap<String, Optional<List<byte[]>>> map = new ImmutableMap.Builder<String, Optional<List<byte[]>>>()
            .put(HOST_1, Optional.<List<byte[]>>of(ImmutableList.<byte[]>of(CERTIFICATE_FINGER_PRINT_1, CERTIFICATE_FINGER_PRINT_2)))
            .put(HOST_2, Optional.<List<byte[]>>absent())
            .put(HOST_3, Optional.<List<byte[]>>of(ImmutableList.<byte[]>of(CERTIFICATE_FINGER_PRINT_1)))
            .build();

    private Optional<List<byte[]>> get(String name) {
        return map.containsKey(name) ? map.get(name) : emptyList_4_certificate_finger_print;
    }
}
