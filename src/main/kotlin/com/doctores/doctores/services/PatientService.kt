package com.doctores.doctores.services

import com.doctores.doctores.domains.request.CreatePatientRequest
import com.doctores.doctores.domains.responses.CreatePatientResponse
import com.doctores.doctores.repositories.PatientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import com.doctores.doctores.domains.entity.Patient

@Service
class PatientService {
    @Autowired
    private lateinit var patientRepository: PatientRepository
    fun createPatient(request: CreatePatientRequest): CreatePatientResponse{
        var patient: Patient? =  patientRepository.createPatient(request)
        val patient =  patientRepository.save(
            Patient(
                nombre = request.nombre,
                apellido = request.apellido,
                identificacion = request.identificacion,
                telefono = request.telefono

            )
        )
        return CreatePatientResponse(
            idPatient = response.idPaciente,
            nombre = request.nombre,
            apellido = request.apellido,
            identificacion = request.identificacion,
            telefono = request.telefono,
            createAt = Instant.now()
        )
    }

    fun getAllPatients(): List<CreatePatientResponse>{
        var patient: Patient? =  patientRepository.getAllPatients()
        var response : List<CreatePatientResponse> = listOf(
            CreatePatientResponse(
                idPatient = patient.idPaciente,
                nombre =    patient.nombre,
                apellido =  patient.apellido,
                identificacion = patient.identificacion,
                telefono = patient.telefono,
                createAt = patient.createAt
            )
        )
        return response
    }

    fun getPatientById(id: Long): CreatePatientResponse {
        var patient: Patient? =  patientRepository.getByPatientId(id)
        if (patient!=null){
            return CreatePatientResponse(
                idPatient = patient.idPaciente,
                nombre =    patient.nombre,
                apellido =  patient.apellido,
                identificacion = patient.identificacion,
                telefono = patient.telefono,
                createAt = Instant.now()
            )
        }else{
            return "Patient not found"
        }



    }

    fun updatePatient(id: Long): CreatePatientResponse{
        var patient: Patient? =  patientRepository.updatePatient(id)
        return CreatePatientResponse(
            idPatient = patient.idPaciente,
            nombre =    patient.nombre,
            apellido =  patient.apellido,
            identificacion = patient.identificacion,
            telefono = patient.telefono,
            createAt = Instant.now()
        )
    }
}