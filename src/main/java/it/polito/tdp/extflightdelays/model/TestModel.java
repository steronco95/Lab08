package it.polito.tdp.extflightdelays.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		model.creaGrafo(3000);
		
//		System.out.println(model.getIdAerei().values());
//		System.out.println(model.getIdAerei().size());
//		System.out.println(model.getIdAreoporti().values());
//		System.out.println(model.getIdAreoporti().size());

		System.out.println(model.getVoli());
//		System.out.println(model.getVoli().size());
//		
//		
//		
		
//		System.out.println(model.vertici());
//		System.out.println(model.archi());
//		System.out.println(model.archi().size());
		
		
	}

}
