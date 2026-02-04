package agency.controllers;

import agency.DAO.ApartmentDAO;
import agency.DTO.ApartmentDTO;
import agency.models.Apartment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/apartments")
public class ApartmentController {

    private final ApartmentDAO apartmentDAO = new ApartmentDAO();

    @GetMapping
    public List<ApartmentDTO> getAll() throws SQLException {
        List<Apartment> apts = apartmentDAO.readAll();
        List<ApartmentDTO> out = new ArrayList<ApartmentDTO>();
        for (Apartment a : apts) {
            out.add(new ApartmentDTO(
                    a.getname(), a.getaddress(), a.getprice(),
                    a.getarea(), a.getfloor(), a.getrooms()
            ));
        }
        return out;
    }

    @GetMapping("/filter")
    public List<ApartmentDTO> filter(@RequestParam int maxPrice) throws SQLException {
        List<Apartment> apts = apartmentDAO.filterByMaxPrice(maxPrice);
        List<ApartmentDTO> out = new ArrayList<ApartmentDTO>();
        for (Apartment a : apts) {
            out.add(new ApartmentDTO(
                    a.getname(), a.getaddress(), a.getprice(),
                    a.getarea(), a.getfloor(), a.getrooms()
            ));
        }
        return out;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ApartmentDTO dto) throws SQLException {
        Apartment a = new Apartment(dto.getName(), dto.getAddress(), dto.getPrice(),
                dto.getArea(), dto.getFloor(), dto.getRooms());
        apartmentDAO.create(a);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{address}/price")
    public ResponseEntity<?> updatePrice(@PathVariable String address, @RequestParam int value) throws SQLException {
        boolean ok = apartmentDAO.updatePrice(address, value);
        if (!ok) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("updated");
    }

    @DeleteMapping("/{address}")
    public ResponseEntity<?> delete(@PathVariable String address) throws SQLException {
        boolean ok = apartmentDAO.deleteByAddress(address);
        if (!ok) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
