chutes = [175,165,158,123]
numeros = []
for i in 0... chutes.size
	puts chutes[i]
end

puts chutes.to_s
puts numeros.to_s

nome = gets

puts "------------------------------------"
puts "O " + nome + " tem " + nome.size.to_s + " Caracteres"

puts "------------------------------------"
puts "O #{nome.strip} tem #{nome.size} Caracteres"

for chute in chutes
	puts chute.to_s
end