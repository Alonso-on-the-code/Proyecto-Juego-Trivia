
package trivia.persistence;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.util.List;
import trivia.models.Usuario;

public class GeneradorPDF {
    
 // 🔹 1. Reporte general de puntuaciones
    public static void generarReportePuntajes(List<Usuario> usuarios) {
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("reporte_puntajes.pdf"));
            doc.open();

            // Encabezado
            doc.add(new Paragraph("📊 Reporte de Puntuaciones - Trivia", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20)));
            doc.add(new Paragraph("Fecha: " + new java.util.Date().toString()));
            doc.add(new Paragraph(" "));

            // Tabla
            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Nombre");
            tabla.addCell("Partidas");
            tabla.addCell("Puntaje Total");

            for (Usuario u : usuarios) {
                tabla.addCell(u.getNombre());
                tabla.addCell(String.valueOf(u.getPartidasJugadas()));
                tabla.addCell(String.valueOf(u.getPuntajeTotal()));
            }

            doc.add(tabla);
            doc.add(new Paragraph("\nGenerado automáticamente por Trivia 🧠", FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 10)));

            doc.close();
            System.out.println("✅ PDF 'reporte_puntajes.pdf' generado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 2. Certificado de logro para un jugador
    public static void generarCertificado(Usuario usuario) {
        try {
            String nombreArchivo = "certificado_" + usuario.getNombre() + ".pdf";
            Document doc = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(doc, new FileOutputStream(nombreArchivo));
            doc.open();

            // Fondo visual (opcional)
            doc.add(new Paragraph("\n\n\n"));
            Paragraph titulo = new Paragraph("🏆 CERTIFICADO DE LOGRO 🏆", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 30, BaseColor.BLUE));
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);

            doc.add(new Paragraph("\n\nEste certificado se otorga a:", FontFactory.getFont(FontFactory.HELVETICA, 16)));
            Paragraph nombre = new Paragraph(usuario.getNombre(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 28));
            nombre.setAlignment(Element.ALIGN_CENTER);
            doc.add(nombre);

            doc.add(new Paragraph("\nPor haber alcanzado un puntaje total de " + usuario.getPuntajeTotal() + " puntos en el juego de Trivia.", FontFactory.getFont(FontFactory.HELVETICA, 16)));

            doc.add(new Paragraph("\n\nFecha: " + new java.util.Date().toString(), FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 12)));
            doc.add(new Paragraph("\nFirma: _________________________", FontFactory.getFont(FontFactory.HELVETICA, 14)));
            doc.add(new Paragraph("\n\n¡Excelente desempeño! 🎉", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.GREEN)));

            doc.close();
            System.out.println("✅ Certificado generado: " + nombreArchivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
