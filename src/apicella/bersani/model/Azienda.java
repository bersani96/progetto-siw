package apicella.bersani.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;

import apicella.bersani.repository.ResponsabileRepository;

@Entity
public class Azienda {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String nome;
	
	@OneToMany(cascade= {CascadeType.ALL})
	private List<Allievo> allievi;
	
	@OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
	private Responsabile responsabile;
	
	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="azienda")
	private List<Responsabile> responsabili;
	


	public Responsabile makeLogin(Responsabile responsabileDaLoggare) {
		System.out.println("Inizio makeLogin");
		Responsabile result;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto-siw-unit");
		EntityManager em = emf.createEntityManager();
		ResponsabileRepository repo = new ResponsabileRepository(em);
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Responsabile r = repo.findByEmail(responsabileDaLoggare.getEmail());
		tx.commit();
		
		if(r!=null && r.checkLogin(responsabileDaLoggare.getPassword()))
		{
			result = r;
			
		}else
		{
			result = null;
		}
		em.close();
		emf.close();
		return result;
	}
	
	// Getter e setters - hashcode e equals
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public Responsabile getResponsabile() {
		return responsabile;
	}

	public void setResponsabile(Responsabile responsabile) {
		this.responsabile = responsabile;
	}

	public List<Responsabile> getResponsabili() {
		return responsabili;
	}

	public void setResponsabili(List<Responsabile> responsabili) {
		this.responsabili = responsabili;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allievi == null) ? 0 : allievi.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((responsabile == null) ? 0 : responsabile.hashCode());
		result = prime * result + ((responsabili == null) ? 0 : responsabili.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Azienda other = (Azienda) obj;
		if (allievi == null) {
			if (other.allievi != null)
				return false;
		} else if (!allievi.equals(other.allievi))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (responsabile == null) {
			if (other.responsabile != null)
				return false;
		} else if (!responsabile.equals(other.responsabile))
			return false;
		if (responsabili == null) {
			if (other.responsabili != null)
				return false;
		} else if (!responsabili.equals(other.responsabili))
			return false;
		return true;
	}

	public Azienda() {
	}
	
	
	
}
