/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.InterfaceProdutoDao;
import dao.ProdutoDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Produto;

/**
 *
 * @author EMPRESA
 */
@FacesConverter(forClass = Produto.class)
public class ConverterProduto implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       
        
        Integer codigo = Integer.valueOf(value);
        InterfaceProdutoDao dao = new ProdutoDao();

        return dao.pesquisarPorcodigo(codigo);
    
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Produto produ = (Produto) value;
        return produ.getIdproduto().toString();

    }

}
