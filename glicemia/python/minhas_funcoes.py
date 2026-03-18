from Glicemia import glicemia

def popular_lista(lista, nome_base="../dados.csv"):
    arquivo = open(nome_base, "r", encoding="utf-8")
    for linha in arquivo:
        partes = linha.strip().split(";")
        if len(partes) < 3:
            continue
        obj = glicemia(int(partes[0]), partes[1], partes[2])
        if obj not in lista:
            lista.append(obj)
    arquivo.close()


#DESAFIO = Calcular a media e a mediana dos valores da glecimina de acordo com a data de coleta, ou seja, calcular a media e a mediana dos valores da glicemia para cada data de coleta diferente.
def calcular_media(lista):
    if not lista:
        return 0
    return sum(item.valor for item in lista) / len(lista)

def calcular_mediana(lista):
    n = len(lista)
    if n == 0:
        return 0
    vals = sorted(item.valor for item in lista)
    mid = n // 2
    if n % 2 == 1:
        return vals[mid]
    return (vals[mid - 1] + vals[mid]) / 2