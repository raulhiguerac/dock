package com.doctores.doctores.domains.request

import org.jetbrains.annotations.NotNull

data class CreatePatientRequest(
    @field:NotNull("Cedula is required")
    val identificacion: String,

    val nombre: String,
    val apellido: String,
    val telefono: String,

)