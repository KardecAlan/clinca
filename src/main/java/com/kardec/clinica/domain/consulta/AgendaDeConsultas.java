package com.kardec.clinica.domain.consulta;

import com.kardec.clinica.domain.ValidacaoException;
import com.kardec.clinica.domain.medico.Medico;
import com.kardec.clinica.domain.medico.MedicoRepository;
import com.kardec.clinica.domain.paciente.PacienteRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados) {
        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Paciente não existe");
        }

        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Médico não existe");
        }


        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);

    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatoria quando o medico nao for escolhido");
        }

        List<Medico> medicos = medicoRepository.buscarMedicosLivres(dados.especialidade(), dados.data());

        if (medicos.isEmpty()) {
            throw new ValidacaoException("Nenhum médico disponível para a especialidade e data escolhida");
        }

        return medicos.get(new Random().nextInt(medicos.size()));
    }
}
