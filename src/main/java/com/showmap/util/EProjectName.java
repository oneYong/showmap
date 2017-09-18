package com.showmap.util;

/**
 * Created by WYKIM on 2017-07-05.
 */
public enum EProjectName {
    NAME1
    ,NAME2
    ,NAME3
    ,NAME4
    ,NAME5
    ,NAME6
    ,NAME7
    ,NAME8
    ,NAME9
    ,NAME10
    ,NAME11
    ,NAME12
    ,NAME13
    ,NAME14
    ,NAME15
    ;

    @Override
    public String toString() {
        switch(this) {
            case NAME1: return "마을학교";
            case NAME2: return "현장포럼";
            case NAME3: return "우수마을";
            case NAME4: return "선행사업";
            case NAME5: return "창조적경관생태";
            case NAME6: return "창조적소득체험";
            case NAME7: return "창조적문화복지";
            case NAME8: return "창조적마을종합";
            case NAME9: return "권역단위";
            case NAME10: return "면소재지정비";
            case NAME11: return "읍소재지정비";
            case NAME12: return "중심지선도";
            case NAME13: return "중심지일반";
            case NAME14: return "농촌체험";
            case NAME15: return "농촌인성";
            default: throw new IllegalArgumentException();
        }
    }
}
