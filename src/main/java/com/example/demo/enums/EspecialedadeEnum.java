package com.example.demo.enums;

public enum EspecialedadeEnum {

    NENHUM(0, "Nenhum"),
    PSIQUIATRIA(1, "Psiquiatria"),
    PSICOLOGIA(2, "Psicologia"),
    MENTORIA(3, "Mentoria"),
    COACH(4, "Coach"),
    LIDER_RELIGIOSO(5, "Líder Religioso");

    public static EspecialedadeEnum valueOf(final int value) {
        for (final EspecialedadeEnum type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        return EspecialedadeEnum.NENHUM;
    }

    private final Integer value;

    private final String text;

    EspecialedadeEnum(final Integer value, final String text) {
        this.value = value;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public Integer getValue() {
        return this.value;
    }

    public Integer value() {
        return this.value;
    }
}
