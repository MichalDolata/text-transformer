package pl.put.poznan.transformer.logic.Decorators;

import pl.put.poznan.transformer.logic.TextTransformer;

public class Decorator implements TextTransformer {
    private TextTransformer decorator;
    public Decorator(TextTransformer decorator){
        this.decorator = decorator;
    }

    @Override
    public String transform(String text){
        logger.debug("TransformDecorator call decorator");
        return decorator.transform(text);
    }
}
