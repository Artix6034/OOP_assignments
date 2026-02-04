package agency.controllers;

import agency.DAO.AgentDAO;
import agency.DTO.AgentDTO;
import agency.models.Agent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    private final AgentDAO agentDAO = new AgentDAO();

    @GetMapping
    public List<AgentDTO> getAll() throws SQLException {
        List<Agent> agents = agentDAO.readAll();
        List<AgentDTO> out = new ArrayList<AgentDTO>();
        for (Agent a : agents) {
            out.add(new AgentDTO(
                    a.getname(), a.getphone(), a.getexperience(),
                    a.getstatus(), a.getfeature1(), a.getcity()
            ));
        }
        return out;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AgentDTO dto) throws SQLException {
        Agent a = new Agent(dto.getName(), dto.getPhone(), dto.getExperience(),
                dto.isStatus(), dto.getFeature1(), dto.getCity());

        agentDAO.create(a);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{phone}/experience")
    public ResponseEntity<?> updateExperience(@PathVariable String phone, @RequestParam int value) throws SQLException {
        boolean ok = agentDAO.updateExperience(phone, value);
        if (!ok) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("updated");
    }

    @DeleteMapping("/by-name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name) throws SQLException {
        boolean ok = agentDAO.deleteByName(name);
        if (!ok) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
