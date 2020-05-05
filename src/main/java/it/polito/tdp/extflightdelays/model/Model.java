package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	private Graph<Airport,DefaultWeightedEdge> grafo;
	private Map<Integer,Airline> idAerei;
	private Map<Integer,Airport> idAreoporti;
	private List<Flight> voli;
	
	public Model() {
		
		idAerei = new HashMap<>();
		idAreoporti = new HashMap<>();
		voli = new ArrayList<>();
		
	}
	
	public Graph creaGrafo(int minDistanza) {
		
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		
		dao.loadAllAirlines(idAerei);
		dao.loadAllAirports(idAreoporti);
		dao.loadAllFlights(voli);
		
		Graphs.addAllVertices(this.grafo, idAreoporti.values());
		
		
		for(Flight f : voli) {
			if(idAreoporti.containsKey(f.getAreoportoPartenza()) &&  idAreoporti.containsKey(f.getAreoportoArrivo())) {
				if(f.getDistanzaMedia() > minDistanza) {
					Graphs.addEdge(this.grafo, idAreoporti.get(f.getAreoportoPartenza()), idAreoporti.get(f.getAreoportoArrivo()), f.getDistanzaMedia());
				}
				 
			}
		}
		
		
		
		return grafo;
	}

	public Map<Integer, Airline> getIdAerei() {
		return idAerei;
	}

	public Map<Integer, Airport> getIdAreoporti() {
		return idAreoporti;
	}

	public List<Flight> getVoli() {
		return voli;
	}
	
	public Set<Airport> vertici(){
		
		return this.grafo.vertexSet();
	}
	
	public Set<DefaultWeightedEdge> archi(){
		
		return this.grafo.edgeSet();
	}
	
	
	
	
}
