import random
def popular_aleatorio(lista, quantidade, faixa_inicial, faixa_final):
    """_metodo que popula uma lista com numeros aleatorios dentro de uma faixa_
    Args:
        lista (_int_): _armazena inteiros e aleatorios_
        quantidade (_int_): _total de numeros a serem inseridos_
        faixa_inicial (_int_): _numero inicial da faixa_
        faixa_final (_int_): _numero final da faixa_
    """
    for i in range(quantidade):
        lista.append(random.randint(faixa_inicial, faixa_final))

def exibir_lista(lista):
    """_metodo que recebe uma lista e a exibe um abaixo do outro_

    Args:
        lista (_int_): _armazena inteiros_
    """
    for item in lista:
        print(item)
    print("------------------------------")
    print("Total de elementos:", len(lista))

def copiar_lista(lista_origem, lista_destino):
    """_metodo que copia os elementos de uma lista de origem para uma lista de destino_

    Args:
        lista_origem (_int_): _lista de origem contendo todos os numeros_
        lista_destino (_int_): _lista de destino_
    """
    for item in lista_origem:
        if item not in lista_destino:
            lista_destino.append(item)



