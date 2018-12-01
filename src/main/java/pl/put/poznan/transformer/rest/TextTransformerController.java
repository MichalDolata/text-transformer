package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.lang.String;

import java.util.Arrays;


@RestController
@RequestMapping("/{text}")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,latex") String[] transforms) {

        // log the parameters
        logger.debug("Input: " + text);
        logger.debug("Transformations: " + Arrays.toString(transforms));

        // do the transformation, you should run your logic here, below just a silly example
     /*   TextTransformer transformer = new TextTransformer(transforms);
        try {
            return ResponseEntity.ok(transformer.transform(text));
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }*/
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> post(@PathVariable String text,
                      @RequestBody String[] transforms) {

        // log the parameters
        logger.debug("Input: " + text);
        logger.debug("Transformations: " + Arrays.toString(transforms));

        // do the transformation, you should run your logic here, below just a silly example
        /*TextTransformer transformer = new TextTransformer(transforms);
        try {
            return ResponseEntity.ok(transformer.transform(text));
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }*/
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}


