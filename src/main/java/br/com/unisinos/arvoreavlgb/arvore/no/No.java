package br.com.unisinos.arvoreavlgb.arvore.no;

import java.util.Date;
import java.util.List;

public class No<T> implements Comparable<No<T>> {

    private int altura;
    private int fatorBalanceamento;
    private T valor;
    private Integer indice;
    private No<T> noEsquerdo;
    private No<T> noDireito;

    public No(T valor) {
        this.valor = valor;
        altura = 1;
        this.noEsquerdo = this.noDireito = null;
    }

    public No(T valor, int indice) {
        this.indice = indice;
        this.valor = valor;
        altura = 1;
        this.noEsquerdo = this.noDireito = null;
    }

    public int getAltura() {
        return this.altura;
    }

    public int getFatorBalanceamento() {
        return this.fatorBalanceamento;
    }

    public T getValor() {
        return this.valor;
    }

    public Integer getIndice() {
        return this.indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public No<T> getNoEsquerdo() {
        return this.noEsquerdo;
    }

    public void setNoEsquerdo(No<T> no) {
        this.noEsquerdo = no;
    }

    public No<T> getNoDireito() {
        return this.noDireito;
    }

    public void setNoDireito(No<T> no) {
        this.noDireito = no;
    }

    private void calculaFatorBalancemanto() {
        int alturaEsquerda = possuiNoEsquerdo() ? noEsquerdo.getAltura(): 0;
        int alturaDireita = possuiNoDireito() ? noDireito.getAltura(): 0;
        this.fatorBalanceamento = alturaEsquerda - alturaDireita;
    }

    private void calculaAltura() {
        if (isFolha()) {
            this.altura = 1;
        }
        int alturaEsquerda = 0;
        int alturaDireita = 0;
        if (noEsquerdo != null) {
            alturaEsquerda = noEsquerdo.getAltura();
        }
        if (noDireito != null) {
            alturaDireita = noDireito.getAltura();
        }
        if (alturaEsquerda > alturaDireita) {
            this.altura = alturaEsquerda + 1;
        } else {
            this.altura = alturaDireita + 1;
        }
    }

    @Override
    public int compareTo(No no) {
        int resultado = 0;
        if (valor instanceof String) {
            resultado = ((String) no.getValor()).compareTo((String) valor);
        } else if (valor instanceof Integer) {
            resultado = ((Integer) valor).compareTo((Integer) no.getValor());
        } else if (valor instanceof Long) {
            resultado = ((Long) valor).compareTo((Long) no.getValor());
        } else if (valor instanceof Date) {
            resultado = ((Date) valor).compareTo((Date) no.getValor());
        }
        return resultado;
    }

    public boolean possuiNoEsquerdo() {
        return this.noEsquerdo != null;
    }

    public boolean possuiNoDireito() {
        return this.noDireito != null;
    }

    public boolean isFolha() {
        return this.noEsquerdo != null && this.noDireito != null;
    }

    public No<T> executaBalanceamento() {
        this.calculaAltura();
        this.calculaFatorBalancemanto();
        if (fatorBalanceamento > 1) {
            noEsquerdo.calculaFatorBalancemanto();
            if (noEsquerdo.getFatorBalanceamento() > 0) {// simple right rotation
                return this.rotacaoDireita();
            } else if (noEsquerdo.getFatorBalanceamento() < 0) {// double right rotation
                noEsquerdo = noEsquerdo.rotacaoEsquerda();
                return this.rotacaoDireita();
            } else if (noEsquerdo.getFatorBalanceamento() == 0) {// double right rotation
                return this.rotacaoDireita();
            }
        } else if (fatorBalanceamento < -1) {
            noDireito.calculaFatorBalancemanto();
            if (noDireito.getFatorBalanceamento() < 0) {// simple left rotation
                return this.rotacaoEsquerda();
            } else if (noDireito.getFatorBalanceamento() > 0) {// double left rotation
                noDireito = noDireito.rotacaoDireita();
                return this.rotacaoEsquerda();
            } else if (noDireito.getFatorBalanceamento() == 0) {// double right rotation
                return this.rotacaoEsquerda();
            }
        }
        return null;

    }

    public No apagar(No no) {
        if (this.compareTo(no) > 0) {
            No aux = noDireito.apagar(no);
            if (aux == noDireito) {
                noDireito = null;
            } else if (aux != null) {
                noDireito = aux;
                noDireito.calculaAltura();
            }
        } else if (this.compareTo(no) < 0) {
            No aux = noEsquerdo.apagar(no);
            if (aux == noEsquerdo) {
                noEsquerdo = null;
            } else if (aux != null) {
                noEsquerdo = aux;
                noEsquerdo.calculaAltura();
            }
        } else if (this.compareTo(no) == 0) {
            if (noDireito != null) {
                if (noDireito.getNoEsquerdo() == null) {
                    noDireito.setNoEsquerdo(this.noEsquerdo);
                    return noDireito;

                } else {
                    this.valor = (T) (noDireito.getNoEsquerdo()).getValor();
                    noDireito.apagar(new No(this.valor));
                }
            } else if (noEsquerdo != null) {
                return noEsquerdo;

            } else {
                return this;
            }

        }
        return this.executaBalanceamento();
    }

    public No inserir(No no) {
        if (this.compareTo(no) == 0) {
            return null;// IF FOUND ELEMENT
        }
        if (this.compareTo(no) > 0) {// IF GREATER
            if (noDireito == null) {
                noDireito = no;
            } else {
                No aux = noDireito.inserir(no);
                if (aux != null) {
                    noDireito = aux;
                }
            }
        } else if (this.compareTo(no) < 0) {// IF SMALLER
            if (noEsquerdo == null) {
                noEsquerdo = no;
            } else {
                No aux = noEsquerdo.inserir(no);
                if (aux != null) {
                    noEsquerdo = aux;
                }
            }
        }
        return this.executaBalanceamento();
    }

    private No rotacaoEsquerda() {
        No temp = noDireito;
        if (noDireito.getNoEsquerdo() == null) {
            noDireito.setNoEsquerdo(this);
            this.noDireito = null;
        } else {
            this.noDireito = temp.getNoEsquerdo();
            temp.noEsquerdo = this;
        }
        this.calculaAltura();
        temp.calculaAltura();
        return temp;
    }

    private No rotacaoDireita() {
        No temp = noEsquerdo;
        if (noEsquerdo.getNoDireito() == null) {
            noEsquerdo.setNoDireito(this);
            this.noEsquerdo = null;
        } else {
            this.noEsquerdo = temp.getNoDireito();
            temp.noDireito = this;
        }
        this.calculaAltura();
        temp.calculaAltura();
        return temp;
    }

//    public No busca(No no) {
//        if (this.compareTo(no) == 0) {
//            return this;
//        } else if (this.compareTo(no) < 0) {
//            if (noEsquerdo != null) {
//                return noEsquerdo.busca(no);
//            } else {
//                return null;
//            }
//        } else if (this.compareTo(no) > 0) {
//            if (noDireito != null) {
//                return noDireito.busca(no);
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }

    /**
     * Preenche uma lista com os dados que se encaixam no filtro de datas
     *
     * @param dataInicial Data inicial
     * @param dataFinal Data final
     * @param lista Lista a ser preenchida
     */
    public void buscaPorData(Date dataInicial, Date dataFinal, List<Integer> lista) {
        // Se possui nó esquerdo
        if (possuiNoEsquerdo()) {
            noEsquerdo.buscaPorData(dataInicial, dataFinal, lista);
        }
        // Se a data está entre a data inicial e final
        if (((Date) this.valor).before(dataFinal) && ((Date) this.valor).after(dataInicial)) {
            lista.add(this.indice);
        }
        // Se possui nó direito
        if (possuiNoDireito()) {
            noDireito.buscaPorData(dataInicial, dataFinal, lista);
        }
    }

    /**
     * Preenche uma lista com os valores que iniciam com o valor pesquisado
     *
     * @param filtroPesquisa Nome a ser pesquisado
     * @param lista Lista a ser preenchida
     */
    public void buscaPorNome(String filtroPesquisa, List<Integer> lista) {
        // Se possui nó esquerdo
        if (possuiNoEsquerdo()) {
            noEsquerdo.buscaPorNome(filtroPesquisa, lista);
        }
        // Se o nome inicia com o valor pesquisado
        if (((String) this.valor).startsWith(filtroPesquisa)) {
            lista.add(this.indice);
        }
        // Se possui nó direito
        if (possuiNoDireito()) {
            noDireito.buscaPorNome(filtroPesquisa, lista);
        }
    }

    /**
     * Retorna o indice do nó caso o valor seja igual ao CPF informado
     * 
     * @param cpf CPF
     * @return Long
     */
    public Integer buscaPorCpf(Long cpf) {
        // Se o cpf for igual ao valor do nó
        if (cpf.equals(this.valor)) {
            return this.indice;
        } else if (possuiNoEsquerdo()) {
            // Busca no nó esquerdo, se existir
            return noEsquerdo.buscaPorCpf(cpf);
        } else if (possuiNoDireito()) {
            // Busca no nó direito, se existir
            return noDireito.buscaPorCpf(cpf);
        } else {
            return null;
        }
    }

    public void percursoEmOrdem() {
        if (noEsquerdo != null) {
            noEsquerdo.percursoEmOrdem();
        }
        System.out.print(valor + " ");
        if (noDireito != null) {
            noDireito.percursoEmOrdem();
        }
    }

    public void percursoPosOrdem() {
        if (noEsquerdo != null) {
            noEsquerdo.percursoPosOrdem();
        }
        if (noDireito != null) {
            noDireito.percursoPosOrdem();
        }
        System.out.print(valor + " ");
    }

    public void percursoPreOrdem() {
        System.out.print(valor + " ");

        if (noEsquerdo != null) {
            noEsquerdo.percursoPreOrdem();
        }

        if (noDireito != null) {
            noDireito.percursoPreOrdem();
        }
    }
}