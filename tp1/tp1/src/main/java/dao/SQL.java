package dao;

import org.springframework.stereotype.Component;

@Component
public class SQL implements IDao{
    @Override
    public double getData() {
        return(10);
    }
}
