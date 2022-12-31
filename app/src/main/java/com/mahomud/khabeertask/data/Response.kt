package com.mahomud.khabeertask.data

data class Response(
    val Activation: Boolean,
    val ArabicMessage: String,
    val EnglishMessage: String,
    var Payroll: Payrol,
    val Success: Boolean
) {
    data class Payrol(
        val Allowences: List<Allowence>,
        val Date: String,
        val Deduction: List<Deductions>,
        val Employee: List<Employees>
    ) {
        data class Allowence(
            val COMP_DESC_AR: String,
            val COMP_DESC_EN: String,
            val EMP_ID: Int,
            val SAL_COMP_CODE: Int,
            val SAL_COMP_TYPE: Int,
            val SAL_VALUE: Double
        )

        data class Deductions(
            val COMP_DESC_AR: String,
            val COMP_DESC_EN: String,
            val EMP_ID: Int,
            val SAL_COMP_CODE: Int,
            val SAL_COMP_TYPE: Int,
            val SAL_VALUE: Double
        )

        data class Employees(
            val ATM_ACCOUNT: Any,
            val COMP_DESC_A_AR: String,
            val COMP_DESC_A_EN: String,
            val COMP_DESC_D_AR: String,
            val COMP_DESC_D_EN: String,
            val CONTRACTSTDATE: String,
            val CURRSYMBOL_AR: String,
            val CURRSYMBOL_EN: String,
            val CUSTOM_ID: Double,
            val EMP_DATA_AR: String,
            val EMP_DATA_EN: String,
            val EMP_GENDUR: String,
            val EMP_ID: Int,
            val EMP_PIC: Any,
            val FRACTIONNAME_AR: String,
            val FRACTIONNAME_EN: String,
            val JOBCODE: Double,
            val JOBNAME_AR: String,
            val JOBNAME_EN: String,
            val MAR_STATUS_AR: String,
            val MAR_STATUS_EN: String,
            val SAL_COMP_CODE_A: Double,
            val SAL_COMP_CODE_D: Double,
            val SAL_VALUE_A: Double,
            val SAL_VALUE_D: Double,
            val SAL_VALUE_NET: Double,
            val SEC_NAME_AR: String,
            val SEC_NAME_EN: String,
            val STATUSNAME_AR: String,
            val STATUSNAME_EN: String,
            val STATUS_AR: String,
            val STATUS_EN: String
        )
    }
}