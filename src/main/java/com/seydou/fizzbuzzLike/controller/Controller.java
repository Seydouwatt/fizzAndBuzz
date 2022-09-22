package com.seydou.fizzbuzzLike.controller;

import com.seydou.fizzbuzzLike.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fizz")
public class Controller {

    Map<String, Integer> stats = new HashMap<>();

    @GetMapping("/stats")
    public String getStats(){
        String result = "";
        Integer  temp = 0;
        for(Map.Entry<String,Integer> entry : stats.entrySet()){
            if(temp <= entry.getValue()){
                temp = entry.getValue();
                result = entry.getKey();
            }
        }
        if(result == ""){
            result = "Aucune requette demandé pour l'instant.";
        }  else {
            result = "La requette utilisant les paramètres suivants a été appelé "
                    + temp + " fois : " + result ;
        }
        return result;
    }


     @PostMapping(value = "/attributePost", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
     public List<String> postFizzBuzz(@RequestParam  Integer int1,
                                      @RequestParam  Integer int2,
                                      @RequestParam  Integer limit,
                                      @RequestParam  String str1,
                                      @RequestParam  String str2){

         // chaine servant de clef
         String key = String.valueOf(int1)+ " - "
                 + String.valueOf(int2)+ " - "
                 + String.valueOf(limit)+ " - "
                 + str1+ " - "
                 + str2;
         if(stats.containsKey(key)){
             stats.replace(key,stats.get(key)+1);
         }else{
             stats.put(key, 1);
         }

         List<String> list = Utils.getResultList(int1, int2, limit, str1, str2);
         return list;
     }

    @GetMapping("/attribute")
    public List<String> getFizzBuzz (@RequestParam Integer int1,
                                     @RequestParam Integer int2,
                                     @RequestParam Integer limit,
                                     @RequestParam String str1,
                                     @RequestParam String str2){

        // chaine servant de clef
        String key = String.valueOf(int1)+ " - "
                + String.valueOf(int2)+ " - "
                + String.valueOf(limit)+ " - "
                + str1+ " - "
                + str2;

                if(stats.containsKey(key)){
                    stats.replace(key,stats.get(key)+1);
                }else{
                    stats.put(key, 1);
                }

        List<String> list = Utils.getResultList(int1, int2, limit, str1, str2);
        return list;


    }
}
