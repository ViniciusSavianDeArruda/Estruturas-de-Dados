from PrevisoesClimaticas.clima import Clima
lista = []
linha = "2020, janeiro,quente,muito"
dadosLinha = linha.split(",")
obj_clima = Clima(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3])

if obj_clima not in lista:
    lista.append(obj_clima)
    
#segunda linha
linha = "2020, janeiro, frio, pouca"
dadosLinha = linha.split(",")
obj_clima = Clima(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3])   

if obj_clima not in lista: #verificar se o objeto clima ja existe na lista, se nao existir adiciona o objeto clima na lista
    lista.append(obj_clima)

for clima in lista:
    print(clima)
    
