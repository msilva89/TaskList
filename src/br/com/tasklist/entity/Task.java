package br.com.tasklist.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    private Long idTask;
    @Column(name = "ds_titulo")
    private String dsTitulo;
    @Column(name = "ds_task")
    private String dsTask;
    @Column(name = "dt_criacao")
    private Date dtCriacao;
    @Column(name = "dt_edicao")
    private Date dtEdicao;
    @Column(name = "dt_remocao")
    private Date dtRemocao;
    @Column(name = "dt_conclusao")
    private Date dtConclusao;
    @Column(name = "cd_status")
    private Integer cdStatus;

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getDsTitulo() {
        return dsTitulo;
    }

    public void setDsTitulo(String dsTitulo) {
        this.dsTitulo = dsTitulo;
    }

    public String getDsTask() {
        return dsTask;
    }

    public void setDsTask(String dsTask) {
        this.dsTask = dsTask;
    }

    public Date getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public Date getDtEdicao() {
        return dtEdicao;
    }

    public void setDtEdicao(Date dtEdicao) {
        this.dtEdicao = dtEdicao;
    }

    public Date getDtRemocao() {
        return dtRemocao;
    }

    public void setDtRemocao(Date dtRemocao) {
        this.dtRemocao = dtRemocao;
    }

    public Date getDtConclusao() {
        return dtConclusao;
    }

    public void setDtConclusao(Date dtConclusao) {
        this.dtConclusao = dtConclusao;
    }

    public Integer getCdStatus() {
        return cdStatus;
    }

    public void setCdStatus(Integer cdStatus) {
        this.cdStatus = cdStatus;
    }

    public String dtCriacaoString() {
        return dtString(this.dtCriacao);
    }

    public String dtConclusaoString() {
        return dtString(this.dtConclusao);
    }

    public String dtString(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formato.format(data);
        return dataFormatada;
    }

}
