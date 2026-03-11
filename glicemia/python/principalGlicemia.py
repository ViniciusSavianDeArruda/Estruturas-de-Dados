from Glicemia import glicemia

listaGlicemia = []

obj = glicemia(191,"11/03/2026", "9:00")
listaGlicemia.append(obj)

listaGlicemia.append(glicemia(200,"12/03/2026", "10:00"))

for i in range(3):
    valor = int(input("Valor glicemia: "))
    data = input("Data da glicemia: ")
    hora = input("Hora da glicemia: ")
    listaGlicemia.append(glicemia(valor, data, hora))

for item in listaGlicemia:
    print(f"Valor: {item.valor}, Data: {item.data}, Hora: {item.hora}")