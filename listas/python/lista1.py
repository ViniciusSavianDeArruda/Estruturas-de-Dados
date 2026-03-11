from Biblioteca import popular_aleatorio, exibir_lista, copiar_lista_sem_replicados
#declaração de um vetor em pyhton 
lista_numers = []

#recebendo a quantidade de numeros a serem gerados aleatoriamente
quantidade = int(input("Digite a quantidade de numeros a serem gerados: "))

#definindo a faixa de numeros a serem gerados
faixa_inicial = 10
faixa_final = 50

popular_aleatorio(lista_numers, quantidade, faixa_inicial, faixa_final)
exibir_lista(lista_numers)

listar_resultado = []
copiar_lista_sem_replicados(lista_numers, listar_resultado)
listar_resultado.sort()
exibir_lista(listar_resultado)

