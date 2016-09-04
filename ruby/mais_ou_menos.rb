def da_boas_vindas
	puts "Usuario bem vindo ao jogo:"
	puts "Qual é seu nome?"
	nome = gets.strip
	puts "Começaremos o jogo #{nome}"
end

def pedir_dificuldade
	puts "Qual o nível de Dificuldade:"
	puts "Entre 1(muito facíl), 2 (facíl), 3(normal), 4(difícil) e 5 (muito dificíl)"
	dificuldade = gets.to_i
end	

def sorteia_um_numero (dificuldade)
	case dificuldade
	when 1
		maximo = 30
	when 2
		maximo = 60
	when 3
		maximo = 100
	when 4
		maximo = 150
	else
		maximo = 200					
	end

	sorteado = rand(maximo)

	puts "Escolhendo um número secreto entre 0 e #{maximo}..."
	puts "Escolhido.... que tal adivinhar hoje nosso número secreto?"	

	sorteado
end	

def pede_um_numero(tentativa, limite_tentativa)
	
	puts "Tentativa " + tentativa.to_s + " de " + limite_tentativa.to_s
	puts "Digite um número: "
	chute = gets
	chute.to_i
end

def verifica_se_acertou(numero_secreto, chute)
	if numero_secreto == chute
		puts "Acertou o número secreto, Parabéns!!!"
		return true 
	end
		if (numero_secreto-chute) > 0
			puts "Número é Maior #{chute}"
		else 
			puts "Número é Menor #{chute}"
		end	
		return false
end

def jogo
dificuldade = pedir_dificuldade	
numero_secreto = sorteia_um_numero(dificuldade)
pontos_ate_agora = 1000
pontos_a_perder = 0.0
limite_tentativa =6
numeros = []

for tentativa in 1.. limite_tentativa
	if numeros.size !=0 
		puts "Você já chutou: " + numeros.to_s
	end
	chute = pede_um_numero tentativa,limite_tentativa
	numeros << chute 
	pontos_a_perder = (chute - numero_secreto)/2
		
	pontos_ate_agora -= pontos_a_perder.abs
	break if verifica_se_acertou(numero_secreto,chute) 

		
end

puts "\n \n"
puts "O numero secreto era " + numero_secreto.to_s
puts "Você ganhou #{pontos_ate_agora} pontos."	
puts "\n \n"
end

def jogar_novamente
	puts "Deseja Jogar Novamente (S/N)?"
	quero_jogar = gets.strip
	quero_jogar = quero_jogar.upcase == "N"
end

loop do
da_boas_vindas
jogo
	if jogar_novamente
		break
	end
end
