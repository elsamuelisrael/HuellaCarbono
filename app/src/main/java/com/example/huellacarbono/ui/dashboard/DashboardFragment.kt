package com.example.huellacarbono.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.huellacarbono.databinding.FragmentDashboardBinding
import java.util.Locale

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configurar el botón de calcular
        binding.buttonCalculate.setOnClickListener {
            calculateCarbonFootprint()
        }

        // Configurar el botón de limpiar
        binding.buttonReset.setOnClickListener {
            resetFields()
        }

        return root
    }

    private fun calculateCarbonFootprint() {
        // Obtener valores de los campos de entrada
        val electricity = binding.inputElectricity.text.toString().toDoubleOrNull() ?: 0.0
        val gas = binding.inputGas.text.toString().toDoubleOrNull() ?: 0.0
        val car = binding.inputCar.text.toString().toDoubleOrNull() ?: 0.0
        val publicTransport = binding.inputPublicTransport.text.toString().toDoubleOrNull() ?: 0.0
        val meat = binding.inputMeat.text.toString().toDoubleOrNull() ?: 0.0
        val waste = binding.inputWaste.text.toString().toDoubleOrNull() ?: 0.0

        // Factores de emisión (kg CO₂ por unidad)
        val electricityFactor = 0.5  // kg CO₂ por kWh
        val gasFactor = 2.0          // kg CO₂ por m³
        val carFactor = 0.21         // kg CO₂ por km
        val publicTransportFactor = 0.05  // kg CO₂ por km
        val meatFactor = 6.0         // kg CO₂ por kg de carne (semanal)
        val wasteFactor = 0.5        // kg CO₂ por kg de residuos

        // Calcular emisiones por categoría
        val familyEmissions = (electricity * electricityFactor) + (gas * gasFactor)
        val transportEmissions = (car * carFactor) + (publicTransport * publicTransportFactor)
        val lifestyleEmissions = (meat * meatFactor * 4) + (waste * wasteFactor) // meat x 4 para convertir semanal a mensual

        // Total de huella de carbono mensual
        val totalEmissions = familyEmissions + transportEmissions + lifestyleEmissions

        // Convertir a toneladas anuales
        val annualTons = (totalEmissions * 12) / 1000

        // Mostrar resultado
        binding.textResult.text = String.format(
            Locale.getDefault(),
            "Tu huella de carbono es:\n%.2f kg CO₂/mes\n(%.2f toneladas/año)",
            totalEmissions,
            annualTons
        )

        // Mostrar detalles
        val details = buildString {
            append("Desglose de emisiones:\n\n")
            append(String.format(Locale.getDefault(), "🏠 Entorno Familiar: %.2f kg CO₂\n", familyEmissions))
            append(String.format(Locale.getDefault(), "   • Electricidad: %.2f kg CO₂\n", electricity * electricityFactor))
            append(String.format(Locale.getDefault(), "   • Gas: %.2f kg CO₂\n\n", gas * gasFactor))
            append(String.format(Locale.getDefault(), "🚗 Transporte: %.2f kg CO₂\n", transportEmissions))
            append(String.format(Locale.getDefault(), "   • Auto: %.2f kg CO₂\n", car * carFactor))
            append(String.format(Locale.getDefault(), "   • Transporte público: %.2f kg CO₂\n\n", publicTransport * publicTransportFactor))
            append(String.format(Locale.getDefault(), "🍽️ Estilo de Vida: %.2f kg CO₂\n", lifestyleEmissions))
            append(String.format(Locale.getDefault(), "   • Carne: %.2f kg CO₂\n", meat * meatFactor * 4))
            append(String.format(Locale.getDefault(), "   • Residuos: %.2f kg CO₂\n\n", waste * wasteFactor))

            // Agregar interpretación
            append("\n📊 Interpretación:\n")
            when {
                annualTons < 4.0 -> append("¡Excelente! Tu huella es menor al promedio mundial.")
                annualTons < 8.0 -> append("Bueno. Tu huella está cerca del promedio mundial.")
                annualTons < 12.0 -> append("Moderado. Hay oportunidades para reducir tu huella.")
                else -> append("Alto. Considera implementar medidas para reducir tu huella.")
            }
        }

        binding.textDetails.text = details
        binding.textDetails.visibility = View.VISIBLE

        // Mostrar mensaje de éxito
        Toast.makeText(requireContext(), "Cálculo completado", Toast.LENGTH_SHORT).show()
    }

    private fun resetFields() {
        // Limpiar todos los campos de entrada
        binding.inputElectricity.text.clear()
        binding.inputGas.text.clear()
        binding.inputCar.text.clear()
        binding.inputPublicTransport.text.clear()
        binding.inputMeat.text.clear()
        binding.inputWaste.text.clear()

        // Limpiar resultados
        binding.textResult.text = ""
        binding.textDetails.text = ""
        binding.textDetails.visibility = View.GONE

        // Mostrar mensaje
        Toast.makeText(requireContext(), "Campos limpiados", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}