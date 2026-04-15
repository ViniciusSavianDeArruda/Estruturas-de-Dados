from Matriz import Matriz

dimensao = 10
matriz = [[0 for _ in range(dimensao)] for _ in range(dimensao)]

# gerando uma matriz especial
matriz[2][4] = 1
matriz[4][6] = 1
matriz[2][4] = 1
matriz[7][1] = 1
matriz[8][3] = 1

Matriz.exibirMatriz(matriz, dimensao, dimensao)


listaEspecial = []
Matriz.converterMatriz(matriz, dimensao, dimensao, listaEspecial)
Matriz.exibirMatriz(matriz, dimensao, dimensao)
