from dado import Dado
class Matriz:
    
    @staticmethod
    def exibirMatriz(matriz, qtd_linhas, qtd_colunas):
        for i in range (qtd_linhas):
            for j in range (qtd_colunas):
                print(f"{matriz[i][j]}\t", end=" ")

        print()
        
    @staticmethod
    def ConverterMatriz(matriz, qtd_linhas, qtd_colunas, listaEspecial):
        for i in range (qtd_linhas):
            for j in range (qtd_colunas):
                if matriz[i][j] != 0:
                    lista.append(Dado(matriz[i][j], i, j))
                    listaEspecial.append(Dado(matriz[i][j], i, j))
    
    @staticmethod
    def exbir_lista(lista):
        for item in lista:
            print(item)

        print(f"Total de elementos na lista especial: {len(listaEspecial)}")
