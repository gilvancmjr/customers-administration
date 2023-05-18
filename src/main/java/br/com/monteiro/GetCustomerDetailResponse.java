//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2023.05.18 às 11:17:59 AM GFT 
//


package br.com.monteiro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomerDetaisl" type="{http://monteiro.com.br}CustomerDetaisl"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "customerDetaisl"
})
@XmlRootElement(name = "GetCustomerDetailResponse")
public class GetCustomerDetailResponse {

    @XmlElement(name = "CustomerDetaisl", required = true)
    protected CustomerDetaisl customerDetaisl;

    /**
     * Obtém o valor da propriedade customerDetaisl.
     * 
     * @return
     *     possible object is
     *     {@link CustomerDetaisl }
     *     
     */
    public CustomerDetaisl getCustomerDetaisl() {
        return customerDetaisl;
    }

    /**
     * Define o valor da propriedade customerDetaisl.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerDetaisl }
     *     
     */
    public void setCustomerDetaisl(CustomerDetaisl value) {
        this.customerDetaisl = value;
    }

}
