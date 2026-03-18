from PrevisoesClimaticas.clima import Clima

lista = []
nome_base = "baseClimatica.csv"

#abrindo o arquivo de dados climaticos
try:
    leitor = open(f"PrevisoesClimaticas/{nome_base}", "r", encoding="utf-8")
    
    for linha in leitor:
        dadosLinha = linha.strip().split(",")
        obj_clima = Clima(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3])
        lista.append(obj_clima)
    
    leitor.close()
    
    for item in lista:
        print(item)
        
except Exception as e:
    print("Erro ao abrir o arquivo...", e)