from Glicemia import glicemia

listaGlicemia = []
linha = "120;11/03/2026;9:00"

#splitar a linha
vetor_linhas = linha.split(";")

#criar objeto glicemia
obj = glicemia(int(vetor_linhas[0]), vetor_linhas[1], vetor_linhas[2])

if obj not in listaGlicemia:
    listaGlicemia.append(obj)



