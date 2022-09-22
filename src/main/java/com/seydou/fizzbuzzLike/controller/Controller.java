package com.seydou.fizzbuzzLike.controller;

import com.seydou.fizzbuzzLike.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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


    /**
     * Return a list contains results by post http methode
     * @param int1 first multiple
     * @param int2 second multiple
     * @param limit limit of results
     * @param str1 word to replace with first multiple matches
     * @param str2 word to replace with first multiple matches
     * @return result
     */
     @PostMapping(value = "/attributePost", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
     public List<String> postFizzBuzz(@RequestParam  Integer int1,
                                      @RequestParam  Integer int2,
                                      @RequestParam  Integer limit,
                                      @RequestParam  String str1,
                                      @RequestParam  String str2){

         // nettoyage
         int1 = Utils.sanityzeMultibple(int1);
         int2 = Utils.sanityzeMultibple(int2);
         limit = Utils.sanityzeLimit(limit);
         // chaine servant de clef
         String key = Utils.getKeyByParam(int1,int2,limit, str1, str2);
         // maj de la map
         settingMapResult(key);
         // on constitue le resultat à retourner
         List<String> list = Utils.getResultList(int1, int2, limit, str1, str2);
         return list;
     }



    /**
     * Return a list contains results by get http methode
      * @param int1 first multiple
     * @param int2 second multiple
     * @param limit limit of results
     * @param str1 word to replace with first multiple matches
     * @param str2 word to replace with first multiple matches
     * @return result
     */
    @GetMapping("/attribute")
    public List<String> getFizzBuzz (@RequestParam Integer int1,
                                     @RequestParam Integer int2,
                                     @RequestParam Integer limit,
                                     @RequestParam String str1,
                                     @RequestParam String str2){
        // nettoyage
        int1 = Utils.sanityzeMultibple(int1);
        int2 = Utils.sanityzeMultibple(int2);
        limit = Utils.sanityzeLimit(limit);
        // chaine servant de clef
        String key = Utils.getKeyByParam(int1,int2,limit, str1, str2);
        // maj de la map
        settingMapResult(key);
        // on constitue le resultat à retourner
        List<String> list = Utils.getResultList(int1, int2, limit, str1, str2);
        return list;


    }


    /**
     * Set or update the map result
     * @param key
     */
    private void settingMapResult(String key) {
        if (stats.containsKey(key)) {
            stats.replace(key, stats.get(key) + 1);
        } else {
            stats.put(key, 1);
        }
    }
}
