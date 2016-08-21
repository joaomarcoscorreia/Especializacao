puts "Usuario bem vindo ao jogo:"

puts "Qual é seu nome?"

nome = gets

puts "Começaremos o jogo " + nome
numero_secreto = 175
chute = "0"
i = 1

quente = "Acima"
frio = "Abaixo"

while chute.to_i != numero_secreto
	
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
puts "Parabéns " + nome
puts "Você acaba de adivinhar o número!!!"
