package com.code.frame.basecode.enumeration;

/**
 * 用法六：使用接口组织枚举
 *
 */
public interface EnumInterFace {
    enum Coffee implements EnumInterFace {
        BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
    }
    enum Dessert implements EnumInterFace {
        FRUIT, CAKE, GELATO
    }
}
