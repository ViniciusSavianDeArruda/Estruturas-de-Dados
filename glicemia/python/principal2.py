from Glicemia import glicemia

listaGlicemia = []
nome_base = os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", "dados.csv")

#ler do arquivo e popular a lista com dados splitados
popular_arquivo = open(nome_base, "r")
exibir_lista(listaGlicemia)

popular_arquivo.close();