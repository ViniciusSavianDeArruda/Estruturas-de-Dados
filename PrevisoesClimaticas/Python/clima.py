class Clima:
    def __init__(self, ano, mes, temperatura, precipitacao):
        #constructor da classe clima, recebe o ano, mes, temperatura e precipitacao        
        self.ano = ano
        self.mes = mes
        self.temperatura = temperatura
        self.precipitacao = precipitacao

    def __str__(self):
        return f"Dados climaticos(Ano:{self.ano}, Mes:{self.mes}, Temperatura:{self.temperatura}, Precipitacao:{self.precipitacao})"

    def __eq__(self, object):
        return self.ano == object.ano and self.mes == object.mes and self.temperatura == object.temperatura and self.precipitacao == object.precipitacao
