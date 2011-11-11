class
	MC72

create
	make

feature -- Initialization

	make
			-- Initialization for `Current'.
		do

		end

feature {NONE} -- Access
	misil : MISIL
	preparar : BOOLEAN
	apuntar : BOOLEAN

feature {NONE} -- Access
	Hay_Misiles: BOOLEAN is
			--
			local
				r : RANDOM
				t : DATE_TIME
			do
				create r.make;
				create t.make_now;
				r.set_seed (t.seconds);
				result := (r.next_random (t.seconds) \\ 2) = 0;
			end

feature {NONE} -- Access
	Setup_Misil is
			--			
			do
				if (Hay_Misiles()) then
					create misil.make;
				else --fallar
					generar_Falla();
				end
			ensure
				Hay_Misil: misil /= Void;
			rescue
				-- fallar
			end

feature {NONE} -- Access
	Cargar_Misil is
			--
			require
				Hay_Misil: misil /= Void;
			do
				misil.Activar;
			rescue
				-- fallar
			end

feature {NONE}-- Access
	generar_Falla is
			--
			local
				n : INTEGER
			do
				-- Generar error diviendo por 0 a un entero.
				n := n.integer_quotient (0);
			rescue
				-- fallar
			end

feature -- Access
	Preparar_Misil is
			--
			local
			bandera : INTEGER
			do
				Setup_Misil();
				bandera := 1;
				Cargar_Misil();
				preparar := true;
			ensure
				Misil_Preparado: misil_Preparado()
			rescue
				if (bandera = 1) then
					-- Falló Cargar_Misil, reintentar.
					bandera := 0;  -- Resetear bandera
					retry
				end
				-- Falló Setup_Misil, fallar.
			end

feature -- Access
	Apuntar_Misil (objetivo: STRING) is
			--
			require
				Misil_Preparado: misil_Preparado()
			do
				misil.Fijar_Blanco(objetivo);
				apuntar := true;
			ensure
				Misil_Apuntado: misil_Apuntado()
			rescue
				-- fallar
			end

feature -- Access
	Lanzar_Misil is
			--
			require
				Misil_Apuntado: misil_Apuntado()
			do
				misil.Despegar;
			rescue
				-- fallar
			end

feature -- Access
	misil_Preparado (): BOOLEAN is
			--
			do
				result := preparar;
			end

feature -- Access
	misil_Apuntado (): BOOLEAN is
			-- 	
			do
				result := apuntar;
			end


end
