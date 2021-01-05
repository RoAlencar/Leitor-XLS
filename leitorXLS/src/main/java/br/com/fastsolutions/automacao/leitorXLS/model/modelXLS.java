package br.com.fastsolutions.automacao.leitorXLS.model;

import lombok.Data;

@Data

public class modelXLS {
		public int id;

		private String Local;

		private String TotalLocal;

		private String Estadual;

		private String TotalEstadual;

		private String Nacional;

		private String TotalNacional;

		public void Calculo () {
		}

		public void Calculo(String Local, String Estadual, String Nacional, String TotalLocal, String TotalEstadual, String TOtalNacional) {
			this.Local = Local;
			this.TotalLocal = TotalLocal;
			this.Estadual = Estadual;
			this.TotalEstadual = TotalEstadual;
			this.Nacional = Nacional;
			this.TotalNacional = TotalNacional;
					}
	}
		
