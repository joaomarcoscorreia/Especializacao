def da_boas_vindas
	puts "Usuario bem vindo ao jogo:"
	puts "Qual é seu nome?"
	nome = gets
	puts "Começaremos o jogo " + nome
end

def jogo
numero_secreto = 175
chute = "0"
i = 1
quente = "Acima"
frio = "Abaixo"

while i<=3 && chute.to_i != numero_secreto
	
	puts "Tentativa " + i.to_s
	puts "Digite um número:"
	chute = gets

		if chute.to_i > numero_secreto
			puts quente
		 elsif chute.to_i < numero_secreto
			puts frio
		end
	i+=1
end
puts "\n \n"
puts "O numero secreto era " + numero_secreto.to_s	
puts "\n \n"
end

def teste
	teste.new()
end	

da_boas_vindas
jogo
