package com.doctores.doctores.domains.responses

import java.time.Instant
data class CreatePatientResponse(
    val idPaciente: String,
    val nombre: String,
    val apellido: String,
    val identificacion: String,
    val telefono: String
)
