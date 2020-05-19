/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.extflightdelays;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.extflightdelays.model.Airport;
import it.polito.tdp.extflightdelays.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController extends DefaultWeightedEdge {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="distanzaMinima"
    private TextField distanzaMinima; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalizza"
    private Button btnAnalizza; // Value injected by FXMLLoader

    @FXML
    void doAnalizzaAeroporti(ActionEvent event)  {
    	
    	int distMinima =0;
    	txtResult.clear();
    	
    	try {
    		
    		distMinima = Integer.parseInt(distanzaMinima.getText());
    	
    		Graph<Airport,DefaultWeightedEdge> grafo = model.creaGrafo(distMinima);
    		
    		if(grafo.edgeSet().size() == 0) {
    			txtResult.appendText("La distanza inserita è troppo grande, non esistono areoporti che distano tra loro per piu di: " + distMinima + " miglia \n");
    			txtResult.appendText("inserire una distanza minore!");
    			return;
    		}
    		
    		txtResult.appendText("numero di vertici: " + grafo.vertexSet().size() + "\n");
    		txtResult.appendText("numero di archi: " + grafo.edgeSet().size() + "\n");
    		
    		for(DefaultWeightedEdge s : grafo.edgeSet()) {
    			txtResult.appendText(grafo.getEdgeSource(s) + " --> " + grafo.getEdgeTarget(s) + " " + grafo.getEdgeWeight(s) + "\n");
    		}
    		

    		return;
    		
    		
    	
    	}catch(NumberFormatException e) {
    		txtResult.appendText("inserire un valore numerico!");
    		return;
    	}
    	
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert distanzaMinima != null : "fx:id=\"distanzaMinima\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnalizza != null : "fx:id=\"btnAnalizza\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
   
   
}
