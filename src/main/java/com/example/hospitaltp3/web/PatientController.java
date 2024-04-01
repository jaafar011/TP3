package com.example.hospitaltp3.web;


import com.example.hospitaltp3.entitites.Patient;
import com.example.hospitaltp3.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/api/index")
    public String index(Model model)
    {
        List<Patient> patientList= patientRepository.findAll();
        model.addAttribute("patientList",patientList);
        return "patients";
    }
    @GetMapping("/api/index2")
    public String index2(Model model,
                         @RequestParam(name = "page",defaultValue = "0") int page,
                         @RequestParam(name = "size",defaultValue = "8") int size,
                         @RequestParam(name="search",defaultValue = "") String search)
    {

        Page<Patient> patientPage = patientRepository.findByNomContains(search,PageRequest.of(page,size));
        model.addAttribute("patientList",patientPage.getContent());
        model.addAttribute("pages",new int[patientPage.getTotalPages()]);
        model.addAttribute("currentpage",page);
        model.addAttribute("searchpages",search);
        return "patients";
    }
    @GetMapping("/api/delete")
     public String delete(Long id,int page,String search)
     {
         patientRepository.delete(patientRepository.findById(id).get());
         return "redirect:/api/index2?page="+page+"&search="+search;
     }
@GetMapping("/api/update")
     public String Update(Long id,Model model)
     {
         Patient p1 = patientRepository.findById(id).get();
         model.addAttribute("patient",p1);
         return "Update";
     }

     @PostMapping("/api/save")
     public String save(Long id,Patient patient)
     {
        patientRepository.save(patient);
//         return "redirect:/api/update?id="+id;
         return "redirect:/api/index2";
     }
}
