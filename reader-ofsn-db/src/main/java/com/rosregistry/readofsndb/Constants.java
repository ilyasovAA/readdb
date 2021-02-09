package com.rosregistry.readofsndb;


import com.rosregistry.readofsndb.domain.DataTypeInfo;
import com.rosregistry.readofsndb.domain.DataTypeName;

import java.util.*;
import java.util.stream.Collectors;

public class Constants {
    public static final Map<String, DataTypeInfo> DATA_TYPE_INFO = new HashMap<>();
    public static final Map<String, String> TABLE_MAPPINGS = new HashMap<>();


    static {
        DATA_TYPE_INFO.put("license_set_id", DataTypeInfo.builder().tableName("licensiar").identifier("").dataTypeName(DataTypeName.table).build());
        DATA_TYPE_INFO.put("founder_set_id", DataTypeInfo.builder().tableName("founder").identifier("").dataTypeName(DataTypeName.table).build());
        DATA_TYPE_INFO.put("okato_id", DataTypeInfo.builder().tableName("voc_okato").identifier("s_OKATO_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("oktmo_id", DataTypeInfo.builder().tableName("voc_oktmo").identifier("OKTMO_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("okato_before_moving_id", DataTypeInfo.builder().tableName("voc_okato").identifier("s_OKATO_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("oktmo_fact_id", DataTypeInfo.builder().tableName("voc_oktmo").identifier("OKTMO_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("oktmo_before_moving", DataTypeInfo.builder().tableName("voc_oktmo").identifier("OKTMO_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("okfs_id", DataTypeInfo.builder().tableName("voc_okfs").identifier("OKFS_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("f_founder_okfs", DataTypeInfo.builder().tableName("voc_okfs").identifier("OKFS_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("okogu_id", DataTypeInfo.builder().tableName("voc_okogu").identifier("OKOGU_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("okved2_calc_main_id", DataTypeInfo.builder().tableName("voc_okved2").identifier("OKVED2_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("okved2_main_id", DataTypeInfo.builder().tableName("voc_okved2").identifier("OKVED2_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("okved2_add_id", DataTypeInfo.builder().tableName("voc_okved2").identifier("OKVED2_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("f_license_okved", DataTypeInfo.builder().tableName("voc_okved2").identifier("OKVED2_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("set_of_okved2_calc_add_id", DataTypeInfo.builder().tableName("voc_okved2").identifier("OKVED2_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).isArray(true).build());
        DATA_TYPE_INFO.put("okato_fact_id", DataTypeInfo.builder().tableName("voc_okato").identifier("s_OKATO_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("okopf_id", DataTypeInfo.builder().tableName("voc_okopf").identifier("OKOPFn_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("okato_parent_id", DataTypeInfo.builder().tableName("voc_okato").identifier("s_OKATO_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("okved2007_add_id", DataTypeInfo.builder().tableName("voc_okved2007").identifier("okved2007_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).isArray(true).build());
        DATA_TYPE_INFO.put("okved2007_main_id", DataTypeInfo.builder().tableName("voc_okved2007").identifier("okved2007_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("okved2007_calc_add", DataTypeInfo.builder().tableName("voc_okved2007").identifier("okved2007_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("okved2007_calc_main_id", DataTypeInfo.builder().tableName("voc_okved2007").identifier("okved2007_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());

        DATA_TYPE_INFO.put("info_source_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("information_source_mark_alfa").vocTypeSysName("VOC_INFORMATION_SOURCE_MARK").dataTypeName(DataTypeName.directory).keys(List.of("name", "short_name")).build());

        DATA_TYPE_INFO.put("type_org_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("tip_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_TYPE_ORG_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("e_founder_type", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("tip_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_TYPE_ORG_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("avg_emp_count_source_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("stat_avg_emp_count_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_AVGEMPCOUNT_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("type_org_calc_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("tip_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_TYPE_ORG_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("sbr_org_type_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("tip_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_TYPE_ORG_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("sbr_observation_org_type_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("tip_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_TYPE_ORG_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("okved2_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("okved2_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_OKVED2_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("kies_code_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("kies_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_KIES_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("state_object_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("state_object_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_STATEOBJECT_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("privatization_property_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("privatization_property_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_PRIVATIZATIONPROPERTY_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("turnover_source_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("turnover_source_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_TURNOVER_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("identification_object_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("identification_object_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_IDENTIFICATIONOBJECT_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("income_source_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("income_source_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_INCOME_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("set_of_aux_state_sector_sna_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("aux_state_sector_sna_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_AUX_STATE_SECTOR_SNS_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("set_of_belonging_state_sector_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("belonging_state_sector_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_BELONGINGSTATESECTOR_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("okved2001_main_id", DataTypeInfo.builder().tableName("voc_okved2001").identifier("okved_2001_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());

        DATA_TYPE_INFO.put("oksm_id", DataTypeInfo.builder().tableName("voc_oksm").identifier("oksm_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("businessman_oksm_id", DataTypeInfo.builder().tableName("voc_oksm").identifier("oksm_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());

        DATA_TYPE_INFO.put("set_of_okved2001_add_id", DataTypeInfo.builder().tableName("voc_okved2001").identifier("okved_2001_alfa").dataTypeName(DataTypeName.directory).keys(List.of("name", "code")).build());
        DATA_TYPE_INFO.put("code_kise_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("code_kise_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_CODEKISE_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("set_of_subject_natural_monopoly_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("em_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_SUBJECTNATURALMONOPOLY_MARK").keys(List.of("name", "short_name")).build());

        DATA_TYPE_INFO.put("formation_metod_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_formation_metod_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_FORMATION_METOD_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("reg_info_elimination_metod_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_elimination_metod_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_ELIMINATION_METOD_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("update_type_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("update_type_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_UPDATE_TYPE_MARK").keys(List.of("name", "short_name")).build());

        DATA_TYPE_INFO.put("availability_financial_statements_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("availability_financial_statements_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_AVAILABILITYFINANCIALSSTATMENT_MARK").keys(List.of("name", "short_name")).build());

        DATA_TYPE_INFO.put("okpd_2", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("okpd2_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_NSI_16806").keys(List.of("name", "short_name")).build());

        DATA_TYPE_INFO.put("VOC_KIES_MARK_IP", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("kies_mark_ip_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_KIES_MARK_IP").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("VOC_NSI_14576", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("oker_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_NSI_14576").keys(List.of("name", "short_name")).build());

        DATA_TYPE_INFO.put("VOC_REGIONS_AREA", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_regions_area_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_REGIONS_AREA").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("VOC_REGIONS_EDGE", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_regions_edge_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_REGIONS_EDGE").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("VOC_LICENSIAR_MARK", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_licensiar_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_LICENSIAR_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("okved2007_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_okved2007_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_OKVED2007_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("set_of_service_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_service_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_SERVICE_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("set_of_licensiar_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_licensiar_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_LICENSIAR_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("formation_of_oktmo_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_formationofoktmo_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_FORMATIONOFOKTMO_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("okved2001_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_okved2001_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_OKVED2001_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("calc_okved_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_okved2007_calc_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_OKVED2007_CALC_MARK").keys(List.of("name", "short_name")).build());

        DATA_TYPE_INFO.put("businessman_activity_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_businessman_activity_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_BUSINESSMAN_ACTIVITY_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("set_of_simplified_tax_system_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_simplified_tax_system_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_SIMPLIFIED_TAX_SYSTEM_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("set_of_businessman_statistical_reporting_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_businessman_statisticalreporting_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_BUSINESSMAN_STATISTICALREPORTING_MARK").keys(List.of("name", "short_name")).build());
        DATA_TYPE_INFO.put("okved2_assign_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_okved2_calc_assign_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_OKVED2_CALC_ASSIGN_MARK").keys(List.of("name", "short_name")).build());

        DATA_TYPE_INFO.put("okved2_calc_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_okved2_calc_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_OKVED2_CALC_MARK").keys(List.of("name", "short_name")).build());
//        DATA_TYPE_INFO.put("okved2_calc_mark_id", DataTypeInfo.builder().tableName("voc_ref_codes").identifier("voc_okved2_calc_mark_alfa").dataTypeName(DataTypeName.directory).vocTypeSysName("VOC_OKVED2_CALC_MARK_IP").keys(List.of("name", "short_name")).build());


        DATA_TYPE_INFO.put("type", DataTypeInfo.builder().tableName("").identifier("on_type").dataTypeName(DataTypeName.directory).keys(List.of("value", "description")).build());
        DATA_TYPE_INFO.put("update_type", DataTypeInfo.builder().tableName("").identifier("update_type").dataTypeName(DataTypeName.directory).keys(List.of("value", "description")).build());



    }

    public static Map<String, Map<String, String>> DIR_ATTR_OFSN_FIELD_MAPPING = new HashMap<>();
    static {
        DIR_ATTR_OFSN_FIELD_MAPPING.put("reporting_periods", Map.of(
                "name", "name",
                "short_name", "short_name",
                "prefix", "prefix"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("OKVED2", Map.of(
                "name", "name",
                "code", "code"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("oksm_alfa", Map.of(
                "name", "name",
                "code", "code"));


        DIR_ATTR_OFSN_FIELD_MAPPING.put("okpd2_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_regions_area_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_okved2_calc_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_okved2_calc_assign_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_businessman_statisticalreporting_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_simplified_tax_system_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_businessman_activity_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_service_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_formationofoktmo_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_okved2001_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_okved2007_calc_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_licensiar_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_okved2007_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_regions_edge_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("kies_mark_ip_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("oker_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("okved_2001_alfa", Map.of(
                "name", "name",
                "code", "code",
                "description", "description"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("OKTMO_alfa", Map.of(
                "name", "name",
                "code", "code"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("s_OKATO_alfa", Map.of(
                "name", "name",
                "code", "code",
                "finish_flag", "finish_flag"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("OKVED2_alfa", Map.of(
                "name", "name",
                "code", "code"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("OKFS_alfa", Map.of(
                "name", "name",
                "code", "code"));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("aux_state_sector_sna_mark", Map.of(
                "name", "name",
                "endDate", "e_date",
                "startDate", "s_date",
                "indexNumber", "seq_num",
                "shortName", "short_name"
        ));
        DIR_ATTR_OFSN_FIELD_MAPPING.put("identification_object_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("aux_state_sector_sna_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"
        ));
        DIR_ATTR_OFSN_FIELD_MAPPING.put("turnover_source_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("privatization_property_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("state_object_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("kies_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("okved2_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("tip_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("information_source_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("stat_avg_emp_count_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("belonging_state_sector_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("income_source_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"
        ));
        DIR_ATTR_OFSN_FIELD_MAPPING.put("kies", Map.of(
                "name", "name",
                "short_name", "short_name",
                "endDate", "e_date",
                "startDate", "s_date"
        ));
        DIR_ATTR_OFSN_FIELD_MAPPING.put("OKOGU", Map.of(
                "code", "code",
                "startDate", "s_date",
                "idNSI", "nsi_id",
                "endDate", "e_date",
                "name", "name"
        ));
        DIR_ATTR_OFSN_FIELD_MAPPING.put("OKOGU_alfa", Map.of(
                "code", "code",
                "name", "name"
        ));
        DIR_ATTR_OFSN_FIELD_MAPPING.put("OKTMO", Map.of(
                "description", "name",
                "code", "code"
        ));
        DIR_ATTR_OFSN_FIELD_MAPPING.put("OKTMO_alfa", Map.of(
                "name", "name",
                "code", "code"
        ));
        DIR_ATTR_OFSN_FIELD_MAPPING.put("OKOPFn", Map.of(
                "name", "name",
                "code", "code"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("OKOPFn_alfa", Map.of(
                "name", "name",
                "code", "code"
        ));
        DIR_ATTR_OFSN_FIELD_MAPPING.put("s_OKVED", Map.of(
                "name", "name",
                "code", "code"
        ));
        DIR_ATTR_OFSN_FIELD_MAPPING.put("okved2007", Map.of(
                "description", "name",
                "code", "code"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("okved2007_alfa", Map.of(
                "name", "name",
                "code", "code"
        ));
        DIR_ATTR_OFSN_FIELD_MAPPING.put("code_kise_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"
        ));
        DIR_ATTR_OFSN_FIELD_MAPPING.put("em_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("update_type_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_elimination_metod_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("voc_formation_metod_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name",
                "seq_num", "seq_num"
        ));

        DIR_ATTR_OFSN_FIELD_MAPPING.put("availability_financial_statements_mark_alfa", Map.of(
                "name", "name",
                "short_name", "short_name"
        ));
    }

    static {
        TABLE_MAPPINGS.put("a_license_num", "serial_number");
        TABLE_MAPPINGS.put("b_license_okpo", "okpo_licensing_authority");
        TABLE_MAPPINGS.put("c_license_nlo", "name_licensing_authority");
        TABLE_MAPPINGS.put("d_license_number", "license_number");
        TABLE_MAPPINGS.put("e_license_undate", "end_date");
        TABLE_MAPPINGS.put("f_license_okved", "okved2_id");
        TABLE_MAPPINGS.put("license_sign", "voc_reference_code_id");

        TABLE_MAPPINGS.put("g_founder_oksm", "oksm_id");
        TABLE_MAPPINGS.put("f_founder_okfs", "okfs_id");
        TABLE_MAPPINGS.put("c_founder_okpo", "okpo");
        TABLE_MAPPINGS.put("i_founder_adress", "address");
        TABLE_MAPPINGS.put("d_founder_name", "name");
        TABLE_MAPPINGS.put("b_founder_okpo_sign", "okpo_mark_id");
        TABLE_MAPPINGS.put("h_founder_reg", "reginfo");
        TABLE_MAPPINGS.put("a_founder_num", "serial_number");
        TABLE_MAPPINGS.put("k_founder_part_per", "share_in_percent");
        TABLE_MAPPINGS.put("j_founder_part_rub", "share_in_rubles");
        TABLE_MAPPINGS.put("e_founder_type", "type_org_id");

        TABLE_MAPPINGS.put("stat_avg_emp_count", "voc_ref_codes");
        TABLE_MAPPINGS.put("okved2_mark", "voc_ref_codes");
        TABLE_MAPPINGS.put("kies", "voc_ref_codes");
        TABLE_MAPPINGS.put("state_object_mark", "voc_ref_codes");
        TABLE_MAPPINGS.put("code_kise_mark", "voc_ref_codes");
        TABLE_MAPPINGS.put("s_OKVED", "voc_okved2001_history");
    }
}
