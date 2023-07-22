package com.doctores.doctores.services

import com.doctores.doctores.domains.request.CreateDoctorRequest
import com.doctores.doctores.domains.responses.CreateDoctorResponse
import com.doctores.doctores.repositories.DoctorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import com.doctores.doctores.domains.entity.Doctor

@Service
class DoctorService {
    @Autowired
    private lateinit var doctorRepository: DoctorRepository
    fun createDoctor(request: CreateDoctorRequest): CreateDoctorResponse{
        var doctor: Doctor? =  doctorRepository.createDoctor(request)
        val doctor =  doctorRepository.save(
            Doctor(
                nombre = request.nombre,
                apellido = request.apellido,
                especialidad = request.especialidad,
                correo = request.correo,
                consultorio = request.consultorio,
            )
        )
        return CreateDoctorResponse(
            idDoctor = 1,
            nombre = request.nombre,
            apellido = request.apellido,
            especialidad = request.especialidad,
            correo = request.correo,
            consultorio = request.consultorio,
            createAt = Instant.now()
        )
    }

    fun getAllDoctors(): List<CreateDoctorResponse>{
        var doctor: Doctor? =  doctorRepository.getAllDoctors()
        var response : List<CreateDoctorResponse> = listOf(
            CreateDoctorResponse(
                idDoctor = doctor.idDoctor,
                nombre = doctor.nombre,
                apellido = doctor.apellido,
                especialidad = doctor.especialidad,
                correo = doctor.correo,
                consultorio = doctor.consultorio,
                createAt = doctor.createAt
            )
        )
        return response
    }

    fun getDoctorById(id: Long): CreateDoctorResponse {
        var doctor: Doctor? =  doctorRepository.getByDoctorId(id)
        if (doctor!=null){
            return CreateDoctorResponse(
                idDoctor = doctor.idDoctor,
                nombre = "test",
                apellido = "test",
                especialidad = "test",
                correo = "test",
                consultorio = 123,
                createAt = Instant.now()
            )
        }else{
            return "Doctor not found"
        }



    }

    fun updateDoctor(id: Long): CreateDoctorResponse{
        var doctor: Doctor? =  doctorRepository.updateDoctor(id)
        return CreateDoctorResponse(
            idDoctor = doctor.idDoctor,
            nombre = doctor.nombre,
            apellido = doctor.apellido,
            especialidad = doctor.especialidad,
            correo = doctor.correo,
            consultorio = doctor.consultorio,
            createAt = Instant.now()
        )
    }
}